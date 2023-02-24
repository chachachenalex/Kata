package mowitnow;

import mowitnow.parser.ParserTondeuse;
import mowitnow.services.OperationTondeuse;
import mowitnow.services.TondeuseUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KataPrincipal {
    protected static List<String> resultsList;

    /**
     * this is the entry of kata
     * @param args filepath and file name
     * @throws ExceptionTondeuse
     * @throws IOException
     */
    public static void main(String... args) throws ExceptionTondeuse, IOException {
        if (args.length == 1) { /*here we put the path and filename in the argument of this jar*/
            File file = new File(args[0]);
            KataPrincipal instance = new KataPrincipal();
            resultsList = instance.launch(file);
            System.out.println(resultsList.toString());
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     * @param file
     * @return positions of tondeuses
     */

    private List<String> launch(File file) throws ExceptionTondeuse, FileNotFoundException {
        if(!file.isFile()){
            throw new ExceptionTondeuse(Constant.FILE_INEXIST);
        }
        ParserTondeuse parser = new ParserTondeuse();
        Scanner scanner = new Scanner(file);
        try {
            readHeader(parser, scanner);
            return readBody(parser, scanner);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private void readHeader(ParserTondeuse parser, Scanner scanner) throws ExceptionTondeuse {
        if (scanner.hasNext()) {
            parser.setPelouse(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new ExceptionTondeuse(
                    Constant.WRONG_FORMAT_FILE);
        }
    }

    private List<String> readBody(ParserTondeuse parser, Scanner scanner) throws ExceptionTondeuse {
        List<String> positionsList = new ArrayList<String>();
        while (scanner.hasNext()) {
            // for each two lines, we begin the treatement
            parser.setTondeuse(scanner.nextLine());

            if (scanner.hasNextLine()) {
                parser.setInstructions(scanner.nextLine().trim());// here we need to delete the possible of blank space or we will get shocked by the result of check format
                positionsList.add(launchFromParser(parser));//convert and launch one by one
            } else {
                throw new ExceptionTondeuse(Constant.WRONG_FORMAT_FILE);
            }
        }
        return positionsList;
    }

        private String launchFromParser(ParserTondeuse parser) throws ExceptionTondeuse {
            if (!parser.executeParse()) {
                throw new ExceptionTondeuse(Constant.WRONG_FORMAT_DATA);
            } else {
                OperationTondeuse operationTondeuse = new OperationTondeuse();
                operationTondeuse.setPelouse(TondeuseUtils
                        .getPelouseInfo(parser.getPelouse()));
                operationTondeuse.setPositionTondeuse(TondeuseUtils
                        .getTonteuseInfo(parser.getTondeuse()));
                operationTondeuse.setListeInstruction(TondeuseUtils
                        .getInstructionsInfo(parser.getInstructions()));
                operationTondeuse.executerInstructions();
                return operationTondeuse.toString();
            }
    }
}
