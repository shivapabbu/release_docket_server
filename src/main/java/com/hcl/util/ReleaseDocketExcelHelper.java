package com.hcl.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.model.Employee;

public class ReleaseDocketExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "SAP_ID", "FRESHER_LATERAL", "Employee_Name", "PROJECT_NAME", "BAND", "RELEASE_DATE",
			"DELIMITATION_DATE_RAS", "REASON_FOR_RELEASE", "PART_OF_ROTATION", "FEEDBACK", "NUMBEROF_MONTHS_WORKED",
			"BOARD_SKILL", "SKILL_SET", "EXP_IN_YRS", "CONTACT_NUMBER", "CURRENT_LOCATION", "LEAVE_PLAN",
			"RELEASE_REQUESTOR", "STATUS" };
	static String SHEET = "Employee";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static ByteArrayInputStream empLoyeesToExcel(List<Employee> employees) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Employee employee : employees) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(employee.getSapId());
				row.createCell(1).setCellValue(employee.getFresherOrLateral());
				row.createCell(2).setCellValue(employee.getEmpName());
				row.createCell(3).setCellValue(employee.getProjectName());
				row.createCell(4).setCellValue(employee.getBand());
				row.createCell(5).setCellValue(employee.getReleaseDate());
				row.createCell(6).setCellValue(employee.getDelimitationDateInRAS());
				row.createCell(7).setCellValue(employee.getReasonforRelease());
				row.createCell(8).setCellValue(employee.getPartOfRotation());
				row.createCell(9).setCellValue(employee.getNoOfMonthsWorked());
				row.createCell(10).setCellValue(employee.getBoardSkil());
				row.createCell(11).setCellValue(employee.getSkillSet());
				row.createCell(12).setCellValue(employee.getExpInYrs());
				row.createCell(13).setCellValue(employee.getContactNumber());
				row.createCell(14).setCellValue(employee.getCurrentLocation());
				row.createCell(15).setCellValue(employee.getLeavePlan());
				row.createCell(16).setCellValue(employee.getReleaseRequestor());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	public static List<Employee> excelToEmployee(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Employee> empList = new ArrayList<Employee>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Employee emp = new Employee();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						emp.setSapId(currentCell.getStringCellValue());
						break;

					case 1:
						emp.setFresherOrLateral(currentCell.getStringCellValue());
						break;

					case 2:
						emp.setEmpName(currentCell.getStringCellValue());
						break;

					case 3:
						emp.setProjectName(currentCell.getStringCellValue());

						break;

					case 4:
						emp.setBand(currentCell.getStringCellValue());

						break;
					case 5:
						emp.setReleaseDate((Date) currentCell.getDateCellValue());

						break;
					case 6:
						emp.setDelimitationDateInRAS((Date) currentCell.getDateCellValue());

						break;
					case 7:
						emp.setReasonforRelease(currentCell.getStringCellValue());

						break;
					case 8:
						emp.setPartOfRotation(currentCell.getStringCellValue());

						break;
					case 9:
						emp.setPerformanceFeedback(currentCell.getStringCellValue());

						break;
					case 10:
						emp.setNoOfMonthsWorked(currentCell.getStringCellValue());

						break;
					case 11:
						emp.setBoardSkil(currentCell.getStringCellValue());

						break;
					case 12:
						emp.setSkillSet(currentCell.getStringCellValue());

						break;
					case 13:
						emp.setExpInYrs(currentCell.getStringCellValue());

						break;
					case 14:
						emp.setContactNumber(currentCell.getStringCellValue());

						break;
					case 15:
						emp.setCurrentLocation(currentCell.getStringCellValue());

						break;
					case 16:
						emp.setLeavePlan(currentCell.getStringCellValue());
						break;
					case 17:
						emp.setReleaseRequestor(currentCell.getStringCellValue());
						break;
					case 18:
						emp.setStatus(currentCell.getStringCellValue());
						break;
					default:
						break;
					}

					cellIdx++;
				}

				empList.add(emp);
			}

			workbook.close();

			return empList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
