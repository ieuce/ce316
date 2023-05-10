package com.example.ce316_project;

import javafx.scene.image.ImageView;

public class LectureConfig {




        private String LectureName;



    private String Lecturername;
        private ImageView image;
        private ImageView image2;

        public LectureConfig(String resumeName, ImageView image) {
            this.LectureName = resumeName;
            this.Lecturername=Lecturername;
            this.image = image;
            this.image2=image2;
        }

        public void setImage(ImageView value) {
            image = value;
        }

        public ImageView getImage() {
            return image;
        }

        public String getLectureName() {
            return LectureName;
        }

        public void setLectureName(String resumeName) {
            this.LectureName = resumeName;
        }
        public ImageView getImage2() {
        return image2;
    }

        public void setImage2(ImageView image2) {
        this.image2 = image2;
    }
    public String getLecturername() {
        return Lecturername;
    }

    public void setLecturername(String lecturername) {
        Lecturername = lecturername;
    }
    }

