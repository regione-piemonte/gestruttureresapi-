/*******************************************************************************
* Copyright Regione Piemonte - 2023
* SPDX-License-Identifier: EUPL-1.2
******************************************************************************/
package it.csi.gescovid.gestruttureresapi.util;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

	public static Date getNextMonday() {
		LocalDate ld = LocalDate.now(ZoneOffset.UTC);
		ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		return Date.from(ld.atStartOfDay(ZoneOffset.UTC).toInstant());
	}
	
	public static boolean isSameDay(Date date1, Date date2) {
	    Instant instant1 = date1.toInstant()
	      .truncatedTo(ChronoUnit.DAYS);
	    Instant instant2 = date2.toInstant()
	      .truncatedTo(ChronoUnit.DAYS);
	    return instant1.equals(instant2);
	}
}
