package org.firstinspires.ftc.teamcode.SummerCampTemplate;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "AutoTemplate")
public class AutoTemplate extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    HardwareTemplate robot = HardwareTemplate.getInstance();
    String color = "";

    public void runOpMode() {

        robot.init(hardwareMap);
        /*After init*/
        telemetry.addData("Status", "Hello, Drivers!");

        //Code to test color sensor
        while(!isStarted() && !opModeIsActive()) {
            color = determineAutonomousSensor();
            telemetry.addData("Red", robot.colorSensor.red());
            telemetry.addData("Blue", robot.colorSensor.blue());
            telemetry.addData("Green", robot.colorSensor.green());
            telemetry.addData("Color", color);
            telemetry.update();
        }

        waitForStart();

        /*After play*/

        //Move forward to color panel
        encoderMove(1, 0.1);

        //Sense color panel
        color = determineAutonomousSensor();

        /**Code for Autonomous Color being red*/
        if (color.equals("red")) {
            //Move forward to cone
            timeMove(1, 0.1);

            //Grab cone

            //Move forward to basket

            //Turn to basket
            turning(9000, 0.5);

            //Get to ramp

        }

        /**Code for Autonomous Color being blue*/
        if (color.equals("blue")) {
            //Move forward to cone
            timeMove(1, 0.1);

            //Grab cone

            //Move forward to basket

            //Turn to basket

            //Get to ramp

        }
    }

    //Method to move using encoders - distanceMoving is in inches
    public void encoderMove(double distance, double speed) {

        double wheelCircumfrance = 3.5 * Math.PI;
        double wheelMotor = 537.7;
        double ticks = (distance * (wheelMotor / wheelCircumfrance));

        robot.setPower(0, 0);

        robot.demoMotor1.setTargetPosition((int) Math.round(ticks));
        robot.demoMotor2.setTargetPosition((int) Math.round(ticks));

        robot.demoMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.demoMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.demoMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.demoMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speed, speed);

        while (opModeIsActive() && (robot.demoMotor1.isBusy())) {

        }
        robot.setPower(0, 0);

        robot.demoMotor1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoMotor2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));

    }

    //Method for moving using time
    public void timeMove(double time, double speed) {

        runtime.reset();

        robot.demoMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.demoMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.demoMotor1.setPower(speed);
        robot.demoMotor2.setPower(-speed);
        while (runtime.seconds() < time) {

        }
        robot.demoMotor1.setPower(0);
        robot.demoMotor2.setPower(0);

        robot.demoMotor1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoMotor2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));

    }

    //Method for turning - separate for left and right?
    public void turning(int ticks, double speed) {

        robot.demoMotor1.setTargetPosition(ticks);
        robot.demoMotor2.setTargetPosition(-ticks);

        robot.demoMotor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.demoMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.demoMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.demoMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speed, -speed);

        while (opModeIsActive() && (robot.demoMotor1.isBusy())) {

        }
        robot.setPower(0, 0);

        robot.demoMotor1.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.demoMotor2.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
    }

    //Method to determine Autonomous Color
    public String determineAutonomousSensor() {

        /*These constant values, i.e. 400, might have to be modified depending on the distance the
        sensor is from the color source */

        if (robot.colorSensor.red() > robot.colorSensor.blue() + 2000 && robot.colorSensor.red() > robot.colorSensor.green() ){
            color = "red";
        } else if (robot.colorSensor.blue() > robot.colorSensor.red() + 2000 && robot.colorSensor.blue() > robot.colorSensor.green()){
            color = "blue";
        } else {

        }

        return color;
    }

}
