package io.avchain.rhymecard.dto.response;

import java.util.List;

public class MemberProfileDto {
    String memberId      ;
    String mobileNumber  ;
    List<String> memberDid;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<String> getMemberDid() {
        return memberDid;
    }

    public void setMemberDid(List<String> memberDid) {
        this.memberDid = memberDid;
    }
}
