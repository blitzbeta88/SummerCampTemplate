package org.firstinspires.ftc.teamcode.SummerCampTemplate;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp (name = "Color Sensor Calibration")
public class ColorSensorCalibration extends LinearOpMode {

    HardwareTemplate robot = HardwareTemplate.getInstance();
    String color = "";
    double thresholdValue = 0;

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        boolean pressingA = false;
        boolean pressingB = false;

        while (opModeIsActive()) {

            telemetry.addData("Threshold: ", thresholdValue);
            telemetry.addLine();
            telemetry.addData("Red: ", robot.colorSensor.red());
            telemetry.addData("Blue: ", robot.colorSensor.blue());
            telemetry.addData("Green: ", robot.colorSensor.green());
            telemetry.addData("Color: ", color);
            telemetry.update();

            if (gamepad1.a && !pressingA) {
                thresholdValue += 0.05;
                pressingA = true;
            } else if (!gamepad1.a) {
                pressingA = false;
            }

            if (gamepad1.b && !pressingB) {
                thresholdValue -= 0.05;
                pressingB = true;
            } else if (!gamepad1.b) {
                pressingB = false;
            }

            if (robot.colorSensor.red() > robot.colorSensor.blue() + thresholdValue && robot.colorSensor.red() > robot.colorSensor.green() ){
                color = "red";
            } else if (robot.colorSensor.blue() > robot.colorSensor.red() + thresholdValue && robot.colorSensor.blue() > robot.colorSensor.green()){
                color = "blue";
            } else {

            }

        }

    }

}
