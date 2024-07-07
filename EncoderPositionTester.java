package org.firstinspires.ftc.teamcode.SummerCampTemplate;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@TeleOp (name = ("Encoder Position Tester"))
public class EncoderPositionTester extends LinearOpMode {

    HardwareTemplate robot = HardwareTemplate.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        int position = 0;
        boolean pressingA = false;
        boolean pressingB = false;

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.a && !pressingA) {
                position += 10;
                pressingA = true;
            } else if (!gamepad1.a) {
                pressingA = false;
            }

            if (gamepad1.b && !pressingB) {
                position -= 10;
                pressingB = true;
            } else if (!gamepad1.b) {
                pressingB = false;
            }

            robot.demoMotor1.setPower(1);
            robot.demoMotor1.setTargetPosition(position);
            robot.demoMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            telemetry.addData("position", position);
            telemetry.update();

        }
    }
}
