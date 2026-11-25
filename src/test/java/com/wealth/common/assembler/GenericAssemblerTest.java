package com.wealth.common.assembler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.wealth.common.model.dto.customer.UserDto;

class GenericAssemblerTest {

	static class UserRow extends Base {
		String id;
		String email;
		String role;
		String passwordHash;
	}

	static class Base {
		Integer sessionVersion;
	}

	static class Flags {
		Integer active;
		String grade;
	}

	static class FlagsDto {
		Boolean active;
		char grade;
	}

	@Test
	void copiesFieldsByNameAndSkipsTheRest() {
		UserRow row = new UserRow();
		row.id = "u1";
		row.email = "a@b.co";
		row.role = "admin";
		row.passwordHash = "secret";
		UserDto dto = GenericAssembler.toDTO(row, UserDto.class);
		assertEquals("u1", dto.getId());
		assertEquals("a@b.co", dto.getEmail());
		assertEquals("admin", dto.getRole());
		assertNull(dto.getMenus());
	}

	@Test
	void copiesInheritedFields() {
		UserRow row = new UserRow();
		row.sessionVersion = 7;
		UserRow copy = GenericAssembler.toEntity(row, UserRow.class);
		assertEquals(7, copy.sessionVersion);
	}

	@Test
	void convertsListsAndSpecialTypes() {
		Flags f = new Flags();
		f.active = 1;
		f.grade = "B";
		FlagsDto dto = GenericAssembler.toDTO(f, FlagsDto.class);
		assertEquals(Boolean.TRUE, dto.active);
		assertEquals('B', dto.grade);
		List<FlagsDto> list = GenericAssembler.toDTOList(List.of(f, f), FlagsDto.class);
		assertEquals(2, list.size());
	}

	@Test
	void concurrentUseIsSafe() throws Exception {
		UserRow row = new UserRow();
		row.id = "u1";
		var pool = java.util.concurrent.Executors.newFixedThreadPool(8);
		var tasks = new java.util.ArrayList<java.util.concurrent.Future<String>>();
		for (int i = 0; i < 200; i++) {
			tasks.add(pool.submit(() -> GenericAssembler.toDTO(row, UserDto.class).getId()));
		}
		for (var t : tasks) {
			assertEquals("u1", t.get());
		}
		pool.shutdown();
	}
}
