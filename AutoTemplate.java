package org.firstinspires.ftc.teamcode.SummerCampTemplate;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "AutoTemplate")
public class AutoTemplate extends LinearOpMode{

    HardwareTemplate robot = HardwareTemplate.getInstance();
    String color = "";

    public void runOpMode() {

        robot.init(hardwareMap);

        telemetry.addData("Status", "Hello, Drivers!");
        telemetry.update();

        waitForStart();

        //Move forward to color panel
        encoderMove(1, 0.5);

        //Sense color panel
        color = determineAutonomousSensor();

        /**Code for Autonomous Color being red*/
        if (color.equals("red")) {
            //Move forward to cone
            encoderMove(1, 0.5);

            //Grab cone

            //Move forward to basket

            //Turn to basket

            //Get to ramp

        }

        /**Code for Autonomous Color being blue*/
        if (color.equals("blue")) {
            //Move forward to cone
            encoderMove(1, 0.5);

            //Grab cone

            //Move forward to basket

            //Turn to basket

            //Get to ramp

        }
    }

    //Method to move using encoders - distanceMoving is in inches
    public void encoderMove(double distanceMoving, double speedMoving) {

        double wheelCircumfrance = 3.5 * Math.PI;
        double wheelMotor = 537.7;
        double ticks = (distanceMoving * (wheelMotor / wheelCircumfrance));

        robot.setPower(0, 0);


        robot.demoMotor1.setTargetPosition((int) Math.round(ticks));
        robot.demoMotor2.setTargetPosition((int) Math.round(ticks));

        robot.demoMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.demoMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.demoMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.demoMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speedMoving, speedMoving);

        while (opModeIsActive() && (robot.demoMotor1.isBusy())) {

        }
        robot.setPower(0, 0);

        robot.demoMotor1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoMotor2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));

    }

    //Method for turning - separate for left and right?
    public void turning(int ticks, double speedMoving) {

        robot.demoMotor1.setTargetPosition(ticks);
        robot.demoMotor2.setTargetPosition(ticks);


        robot.demoMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.demoMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.demoMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.demoMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speedMoving, speedMoving);

        while (opModeIsActive() && (robot.demoMotor1.isBusy())) {

        }
        robot.setPower(0, 0);

        robot.demoMotor1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoMotor2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
    }

    //Method to determine Autonomous Color
    public String determineAutonomousSensor(){

        /*These constant values, i.e. 400, might have to be modified depending on the distance the
        sensor is from the color source */

        if (color.equals("red") && robot.colorSensor.red() > robot.colorSensor.blue() + 400 && robot.colorSensor.red() > robot.colorSensor.green() ){
            color = "red";
        }else if(color.equals("blue") && robot.colorSensor.blue() > robot.colorSensor.red() + 400 && robot.colorSensor.blue() > robot.colorSensor.green()){
            color = "blue";
        }else{

        }
        return color;
    }

}