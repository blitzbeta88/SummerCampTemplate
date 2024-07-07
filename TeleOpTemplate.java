package org.firstinspires.ftc.teamcode.SummerCampTemplate;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TeleOp")
public class TeleOpTemplate extends LinearOpMode {

    HardwareTemplate robot = HardwareTemplate.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Hello, Drivers!");
        telemetry.update();

        if (robot.demoMotor1 != null) {
            robot.demoMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        if (robot.demoMotor2 != null) {
            robot.demoMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        waitForStart();

        boolean pressingA = false;
        boolean option = false;

        while (opModeIsActive()) {

            //movement - Driver 1
            double movement = -gamepad1.left_stick_x;
            double turning = gamepad1.right_stick_y;

            double left = movement + turning;
            double right = movement - turning;

            double max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /= max;
            }

            robot.demoMotor1.setPower(left);
            robot.demoMotor2.setPower(right);

            //other controls such as lift - Driver 2

            //This is how to use a button.
            if(gamepad2.a) {
                //insert code for action here
            }

            //This is how to use the dpad.
            if(gamepad2.dpad_down) {
                //insert code for action here
            }

            //This is how to use a trigger.
            if(gamepad1.right_trigger > 0.1) {
                //insert code for action here
            }

            //This is how to use a bumper.
            if(gamepad1.left_bumper) {
                //insert code for action here
            }

            //This is how to have a button do different things each time when pressed.
            if ((gamepad1.a && !pressingA && option == false)) {
                //insert code for first action here
                option = true;
                pressingA = true;
            } else if ((gamepad1.a && !pressingA && option == true)) {
                //insert code for second action here
                option = false;
                pressingA = true;
            } else if (!gamepad1.a) {
                pressingA = false;
            }
        }
    }
}
