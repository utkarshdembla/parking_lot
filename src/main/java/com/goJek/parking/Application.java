package com.goJek.parking;


import com.goJek.parking.config.Constant;
import com.goJek.parking.service.InputHandler;

import java.io.*;

public class Application {
    public static void main(String args[]) throws IOException {

        InputHandler inputHandler = new InputHandler();
        File inputFile = new File(args[0]);
        String input=null;

            BufferedReader bufferReader = new BufferedReader(new FileReader(inputFile));
            int lineNo = 1;
            while ((input = bufferReader.readLine()) != null)
            {
                input = input.trim();
                    inputHandler.inputCommandService(input,null);
                    lineNo++;
            }


    }



        /*InputHandler inputHandler = new InputHandler();
        String[] strValues = new String[4];
        strValues[0]="6";
        inputHandler.inputCommandService(Constant.createParkingLot,strValues);
        strValues[0]="KA-01-HH-1234";strValues[1]="White";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="KA-01-HH-9999";strValues[1]="White";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="KA-01-BB-0001";strValues[1]="Black";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="KA-01-HH-7777";strValues[1]="Red";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="KA-01-HH-2701";strValues[1]="Blue";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="KA-01-HH-3141";strValues[1]="Black";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="4";
        inputHandler.inputCommandService(Constant.leave,strValues);

        inputHandler.inputCommandService(Constant.status,strValues);

        strValues[0]="KA-01-P-333";strValues[1]="White";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="DL-12-AA-9999";strValues[1]="White";
        inputHandler.inputCommandService(Constant.park,strValues);

        strValues[0]="White";
        inputHandler.inputCommandService(Constant.registrationNumbersForCarsWithColor,strValues);
        inputHandler.inputCommandService(Constant.slotNumbersOfCarsWithColor,strValues);

        strValues[0]="KA-01-HH-3141";
        inputHandler.inputCommandService(Constant.slotNumberForRegistrationNumber,strValues);

        strValues[0]="MH-04-AY-1111";
        inputHandler.inputCommandService(Constant.slotNumberForRegistrationNumber,strValues);*/

       /* strValues[0]="42424";
        inputHandler.inputCommandService(Constant.leave,strValues);

        strValues[0]="14211";strValues[1]="Red";
        inputHandler.inputCommandService(Constant.park,strValues);

        inputHandler.inputCommandService(Constant.status,strValues);

        strValues[0]="Red";
        inputHandler.inputCommandService(Constant.registrationNumbersForCarsWithColor,strValues);

        inputHandler.inputCommandService(Constant.slotNumbersOfCarsWithColor,strValues);

        strValues[0]="14211";
        inputHandler.inputCommandService(Constant.slotNumberForRegistrationNumber,strValues);

*/

}
