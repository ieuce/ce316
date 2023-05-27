package com.example.ce316_project;
import javafx.scene.image.ImageView;
public class DetailedEvaluationTableShow {

    private String student_id;

    private String pinput;

    private String poutput;


    private ImageView image;

    private String output;

    public DetailedEvaluationTableShow(String student_id, String pinput, String poutput, ImageView image, String output) {
        this.student_id = student_id;
        this.pinput = pinput;
        this.poutput = poutput;
        this.image = image;
        this.output = output;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }



    public String getPinput() {
        return pinput;
    }

    public void setPinput(String pinput) {
        this.pinput = pinput;
    }

    public String getPoutput() {
        return poutput;
    }

    public void setPoutput(String poutput) {
        this.poutput = poutput;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
