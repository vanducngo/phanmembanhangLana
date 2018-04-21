package print;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintUtils {

	public static void printOrderId(String orderId) {
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(new PrintOrderId(orderId));

		boolean doPrint = printJob.printDialog();
		if (doPrint) {
			try {
				printJob.print();
			} catch (PrinterException e) {
				e.printStackTrace();
				// The job did not successfully
				// complete
			}
		}
	}
}
