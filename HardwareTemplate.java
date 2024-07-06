package org.firstinspires.ftc.teamcode.SummerCampTemplate;



import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class HardwareTemplate {

    public DcMotor demoMotor1;
    public DcMotor demoMotor2;
    public Servo demoServo;
    public ColorSensor colorSensor;

    public static double maxSpeed = 1;

    private static HardwareTemplate myInstance = null;
    public static HardwareTemplate getInstance() {

        if (myInstance == null) {
            myInstance = new HardwareTemplate();
        }
        return myInstance;
    }

    public void init(HardwareMap hwMap) {

        //initialize motor
        try {
            demoMotor1 = hwMap.get(DcMotor.class, "demoMotor1");
            demoMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoMotor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoMotor1.setPower(0);
        } catch (Exception p_exception) {
            demoMotor1 = null;
        }
        try {
            demoMotor2 = hwMap.get(DcMotor.class, "demoMotor2");
            demoMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoMotor2.setPower(0);
        } catch (Exception p_exception) {
            demoMotor2 = null;
        }

        //initialize servo
        try {
            demoServo = hwMap.get(Servo.class, "demoServo");
        } catch (Exception p_exception) {
            demoServo = null;
        }

        try {
            colorSensor = hwMap.get(ColorSensor.class, "cs");
        } catch (Exception p_excetion) {
            colorSensor = null;
        }

    }

    public void setPower(double motorDemo1, double motorDemo2) {
        if (demoMotor1 != null) {
            demoMotor1.setPower(Range.clip(motorDemo1, -maxSpeed, maxSpeed));
        }
        if (demoMotor2 != null) {
            demoMotor2.setPower(Range.clip(motorDemo2, -maxSpeed, maxSpeed));
        }
    }

}
