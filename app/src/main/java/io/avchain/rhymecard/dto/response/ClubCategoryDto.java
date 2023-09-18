package io.avchain.rhymecard.dto.response;

import java.util.List;

public class ClubCategoryDto {
    int clubCategorySeq;
    String display;
    String categoryCode;
    List<ClubCategoryitem> clubCategoryitem;

    public static class ClubCategoryitem{
        int clubCategoryItemSeq;
        String itemDispaly;

        public int getClubCategoryItemSeq() {
            return clubCategoryItemSeq;
        }

        public void setClubCategoryItemSeq(int clubCategoryItemSeq) {
            this.clubCategoryItemSeq = clubCategoryItemSeq;
        }

        public String getItemDispaly() {
            return itemDispaly;
        }

        public void setItemDispaly(String itemDispaly) {
            this.itemDispaly = itemDispaly;
        }
    }

    public int getClubCategorySeq() {
        return clubCategorySeq;
    }

    public void setClubCategorySeq(int clubCategorySeq) {
        this.clubCategorySeq = clubCategorySeq;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public List<ClubCategoryitem> getClubCategoryitem() {
        return clubCategoryitem;
    }

    public void setClubCategoryitem(List<ClubCategoryitem> clubCategoryitem) {
        this.clubCategoryitem = clubCategoryitem;
    }
}

