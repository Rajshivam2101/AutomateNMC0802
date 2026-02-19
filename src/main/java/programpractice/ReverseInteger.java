package programpractice;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReverseInteger {

    public static void main(String[] args) {


        long num = 8827961625L;

        long reverse = 0;

        for (; num != 0; num = num / 10) {

            long digit = num % 10;

            reverse = reverse * 10 + digit;

        }

        System.out.println("Reversed number is: " + reverse);

    }

}

