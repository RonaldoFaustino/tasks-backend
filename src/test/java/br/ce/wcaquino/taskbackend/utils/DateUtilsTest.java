package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void DeveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void DeveRetornarFalseParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
		
	}
	
	@Test
	public void DeveRetornarTrueParaDatasPresente() {
		LocalDate date = LocalDate.now();
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
		
	}

}
