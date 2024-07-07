package org.firstinspires.ftc.teamcode.SummerCampTemplate;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@TeleOp (name = "Servo Position Tester")
public class ServoPositionTester extends LinearOpMode {

    HardwareTemplate robot = HardwareTemplate.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double position = 0;

        boolean pressingA = false;
        boolean pressingB = false;

        while (opModeIsActive()) {

            if (gamepad1.a && !pressingA) {
                position += 0.05;
                pressingA = true;
            } else if (!gamepad1.a) {
                pressingA = false;
            }

            if (gamepad1.b && !pressingB) {
                position -= 0.05;
                pressingB = true;
            } else if (!gamepad1.b) {
                pressingB = false;
            }

            robot.demoServo.setPosition(position);
            telemetry.addData("Position", position);
            telemetry.update();

        }
    }
}
