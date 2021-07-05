/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Chungus Auto", group="Autonomous")
//@Disabled
public class Auto extends LinearOpMode {
    /* Declare OpMode members. */
    static Hardware robot = new Hardware();
    static ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.setAutoClear(false);
        telemetry.addLine("Status: Booting");
        telemetry.update();

        robot.init(hardwareMap);
        telemetry.addData("Robot initialized: ", true);
        telemetry.update();

        robot.rightFront.setPower(0);
        robot.leftFront .setPower(0);
        robot.rightRear .setPower(0);
        robot.leftRear  .setPower(0);
        robot.intake    .setPower(0);


        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.intake    .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftFront .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightRear .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.leftRear  .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Send telemetry message to signify robot waiting;
        telemetry.addLine("Waiting for start");
        telemetry.update();
        telemetry.setAutoClear(true);


        // Wait for the game to start (driver presses PLAY)
        waitForStart();
//        SussyPath();
        Sussy_Full_Auto();
    }
    public void Sussy_Full_Auto() {
        drive(5909,5970,5978,5832,0.5,6);
        drive(1069,-1124,-1041,1080,0.5,3);
        feed(1, 350);
        drive(1104,-1097,1053,-1044,0.5,3);
        drive(1680,2087,2043,1612,0.5,3);
        feed(-1, 350);
    }

    public void SussyPath() {
        //SAMPLE CODE
//      drive(5600,5600,5600,5600,.6,10000);
//      sleep(100);
//      drive(-5600,-5600,-5600,-5600,.6,10000);
//      sleep(100);
//      drive(-2135,2135,-2135,2135,.6,7000);
//      sleep(100);
//      drive(100,2800,2800,100,.9,10000);
//      sleep(100);
    }

    public void drive (int rightFront, int leftFront, int rightRear, int leftRear, double power, int timeOut) {
        robot.rightFront.setPower(0);
        robot.leftFront .setPower(0);
        robot.rightRear .setPower(0);
        robot.leftRear  .setPower(0);

        robot.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.rightFront.setTargetPosition(rightFront);
        robot.leftFront .setTargetPosition(leftFront);
        robot.rightRear .setTargetPosition(rightRear);
        robot.leftRear  .setTargetPosition(leftRear);

        robot.rightFront.setPower(power);
        robot.leftFront .setPower(power);
        robot.rightRear .setPower(power);
        robot.leftRear  .setPower(power);

        robot.rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftFront .setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightRear .setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftRear  .setMode(DcMotor.RunMode.RUN_TO_POSITION);

        runtime.reset();
        while(timeOut > runtime.milliseconds()
                || robot.rightFront.isBusy()
                || robot.leftFront.isBusy()
                || robot.rightRear.isBusy()
                || robot.leftRear.isBusy()) {
            displayTelemetry();
            sleep(25);
        }
        robot.rightFront.setPower(0);
        robot.rightRear.setPower(0);
        robot.leftFront.setPower(0);
        robot.leftRear.setPower(0);
    }

    public void feed(int direction, int duration) {
        robot.intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.intake.setPower(direction);
        sleep(duration);
        robot.intake.setPower(0);
    }
    
    public void feed_and_move(int direction) {
        robot.intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.intake.setPower(direction);
        drive(500,500,500,500,0.4,1000);
        robot.intake.setPower(0);
    }

    public void displayTelemetry() {
        telemetry.addLine("Drive Encoder ticks")
                .addData("Front Left", robot.leftFront.getCurrentPosition())
                .addData("Front Right", robot.rightFront.getCurrentPosition())
                .addData("Back Left", robot.leftRear.getCurrentPosition())
                .addData("Back Right", robot.rightRear.getCurrentPosition());
        telemetry.update();
    }
}
