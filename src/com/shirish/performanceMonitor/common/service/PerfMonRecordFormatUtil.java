package com.shirish.performanceMonitor.common.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.shirish.performanceMonitor.common.model.PerfMonRecord;
import com.shirish.performanceMonitor.common.util.AFCStringUtils;

/**
 * 
 * @author a560320
 * @version 1.0
 * @created Sep 27, 2013
 */
public class PerfMonRecordFormatUtil {

	public static List<PerfMonRecord> sort(
			List<PerfMonRecord> persistentList) {
		if (persistentList == null || persistentList.size() == 0) {
			return persistentList;
		}

		// sort by start time
		sortByStartTime(persistentList);
		format(persistentList);
		return persistentList;
	}

	private static void sortByStartTime(List<PerfMonRecord> persistentList) {
		Collections.sort(persistentList, new Comparator<PerfMonRecord>() {

			public int compare(PerfMonRecord o1, PerfMonRecord o2) {
				// return (int) ((o1.getStartTime() - o2.getStartTime()) %
				// Integer.MAX_VALUE);
				int thisVal = 0, thatVal = 0;
				if (o1.getStartTime() > o2.getStartTime()) {
					thisVal += 5;
				} else if (o1.getStartTime() < o2.getStartTime()) {
					thatVal += 5;
				}
				if (o1.getTimeSpentNum() > o2.getTimeSpentNum()) {
					thatVal += 3;
				} else {
					thisVal += 3;
				}

				return thisVal - thatVal;
			}

		});
	}

	private static void format(List<PerfMonRecord> persistentList) {
		for (int i = 0; i < persistentList.size(); i++) {
			PerfMonRecord record = persistentList.get(i);
			//record.setChildrenCount(0);
			record.setCallLvlNum(0);
			record.setCallNumTxt("");
			if (i == 0) {
				record.setCallNumTxt("");
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (record.getStopTime() > persistentList.get(j).getStopTime()) {
					continue;
				}
				//upByParent(record, persistentList.get(j));
				break;
			}
		}

		PerfMonRecord lastStopWatchRecord = persistentList.get(persistentList
				.size() - 1);
		lastStopWatchRecord.setCallNumTxt("  ");

	}

	private static String toString(byte[] a) {

		if (a == null)

			return "null";

		int iMax = a.length - 1;

		if (iMax == -1)

			return "[]";

		StringBuilder b = new StringBuilder();

		b.append('[');

		for (int i = 0;; i++) {

			b.append(a[i]);

			if (i == iMax)

				return b.append(']').toString();

			b.append(",");
		}

	}

	public static String encodeStopWatch(List<PerfMonRecord> recordList) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(recordList);
			byte[] record = baos.toByteArray();
			return toString(record);
		} catch (IOException e) {
			return "[]";
		} finally {
			if (!AFCStringUtils.isNull(baos)) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!AFCStringUtils.isNull(baos)) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static List<PerfMonRecord> decodeStopWatch(String byteArray) {
		byte[] b = toByte(byteArray);
		if (b == null)// AFCStringUtils.isEmpty(b))
		{
			return null;
		}
		ByteArrayInputStream byteInput = null;
		ObjectInputStream objectInput = null;
		try {
			byteInput = new ByteArrayInputStream(b);
			objectInput = new ObjectInputStream(byteInput);
			List<PerfMonRecord> recordList = (List<PerfMonRecord>) objectInput
					.readObject();
			return recordList;

		} catch (Exception e) {
			return new ArrayList<PerfMonRecord>();
		} finally {
			if (!AFCStringUtils.isNull(byteInput)) {
				try {
					byteInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (!AFCStringUtils.isNull(objectInput)) {
				try {
					objectInput.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	private static byte[] toByte(String byteArray) {
		if (AFCStringUtils.isBlank(byteArray)) {
			return null;
		}
		byteArray = AFCStringUtils.trim(byteArray.replace('[', ' ').replace(
				']', ' '));
		String[] ar = byteArray.split("\\s*,\\s*");
		byte[] b = new byte[ar.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = Byte.parseByte(ar[i]);

		}
		return b;
	}
}
