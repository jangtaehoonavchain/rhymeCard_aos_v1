package io.avchain.rhymecard.dto.response;

import java.util.List;

public class ClubDto {

    List<Content> content;

    public List<Content> getContent() {
        return content;
    }
    public void setContent(List<Content> content) {
        this.content = content;
    }


    public static class Content {
        int clubSeq;
        String clubName;
        String clubPublicKey;
        String description;
        String operateTime;
        String location;
        String phone;
        String startDate;
        String endDate;
        String clubUrl;
        String podUrl;
        boolean valid;
        String imagePath1;
        String imagePath2;
        String imagePath3;
        String imagePath4;
        String imagePath5;

        ClubCategory clubCategory;

        public ClubCategory getClubCategory() {
            return clubCategory;
        }

        public void setClubCategory(ClubCategory clubCategory) {
            this.clubCategory = clubCategory;
        }

        public static class ClubCategory{
            String display;

            public String getDisplay() {
                return display;
            }

            public void setDisplay(String display) {
                this.display = display;
            }
        }


        public String getClubName() {
            return clubName;
        }

        public void setClubName(String clubName) {
            this.clubName = clubName;
        }

        public String getClubPublicKey() {
            return clubPublicKey;
        }

        public void setClubPublicKey(String clubPublicKey) {
            this.clubPublicKey = clubPublicKey;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getOperateTime() {
            return operateTime;
        }

        public void setOperateTime(String operateTime) {
            this.operateTime = operateTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getClubUrl() {
            return clubUrl;
        }

        public void setClubUrl(String clubUrl) {
            this.clubUrl = clubUrl;
        }

        public String getPodUrl() {
            return podUrl;
        }

        public void setPodUrl(String podUrl) {
            this.podUrl = podUrl;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public String getImagePath1() {
            return imagePath1;
        }

        public void setImagePath1(String imagePath1) {
            this.imagePath1 = imagePath1;
        }

        public String getImagePath2() {
            return imagePath2;
        }

        public void setImagePath2(String imagePath2) {
            this.imagePath2 = imagePath2;
        }

        public String getImagePath3() {
            return imagePath3;
        }

        public void setImagePath3(String imagePath3) {
            this.imagePath3 = imagePath3;
        }

        public String getImagePath4() {
            return imagePath4;
        }

        public void setImagePath4(String imagePath4) {
            this.imagePath4 = imagePath4;
        }

        public String getImagePath5() {
            return imagePath5;
        }

        public void setImagePath5(String imagePath5) {
            this.imagePath5 = imagePath5;
        }

        public int getClubSeq() {
            return clubSeq;
        }

        public void setClubSeq(int clubSeq) {
            this.clubSeq = clubSeq;
        }
    }
}
