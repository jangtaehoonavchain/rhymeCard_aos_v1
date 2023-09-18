package io.avchain.rhymecard.config;

public class RhymeCardConfig {

    private static RhymeCardConfig rhymeCardConfig;
    String token;
    String memberId;
    String clubSeq;
    String did;

    private RhymeCardConfig() {    }

    public static RhymeCardConfig getInstance(){
        if(rhymeCardConfig == null){
            rhymeCardConfig = new RhymeCardConfig();
        }
        return rhymeCardConfig;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getClubSeq() {
        return clubSeq;
    }
    public void setClubSeq(String clubSeq) {
        this.clubSeq = clubSeq;
    }
    public String getDid() {
        return did;
    }
    public void setDid(String did) {
        this.did = did;
    }
}
