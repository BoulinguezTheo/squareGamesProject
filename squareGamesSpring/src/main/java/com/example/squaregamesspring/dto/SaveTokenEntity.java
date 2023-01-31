package com.example.squaregamesspring.dto;

import com.example.squaregamesspring.model.GameInProgress;
import jakarta.persistence.*;

@Entity
@Table(name="tokens")
public class SaveTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long tokenId;

    @ManyToOne
    @JoinColumn(name="game_id")
    private GameEntity gameId;
    @Column(name="token_name")
    private String tokenName;
    @Column(name="token_id_player", nullable=false)
    private String tokenIdPlayer;
    @Column(name="x_old_cor")
    private Integer xOldCor = null;
    @Column(name="y_old_cor")
    private Integer yOldCor = null;
    @Column(name="x_cor", nullable = false)

    private int xNewCor;
    @Column(name="y_cor", nullable=false)
    private int yNewCor;

    public SaveTokenEntity() {
    }
    public SaveTokenEntity(long tokenId, String gameId, String tokenName, String tokenIdPlayer, int xOldCor, int yOldCor, int xNewCor, int yNewCor) {
        this.tokenId = tokenId;
//        this.game = gameId;
        this.tokenName = tokenName;
        this.tokenIdPlayer = tokenIdPlayer;
        this.xOldCor = xOldCor;
        this.yOldCor = yOldCor;
        this.xNewCor = xNewCor;
        this.yNewCor = yNewCor;
    }

    public long getTokenId() {
        return tokenId;
    }
    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }
    public GameEntity getGame() {
        return gameId;
    }
    public void setGame(GameInProgress pGame) {
        this.gameId = createGameEntity(pGame);
    }
    private GameEntity createGameEntity(GameInProgress pGame){
        GameEntity dto = new GameEntity();
        dto.setGameId(pGame.getGameId());
        dto.setGameName(pGame.getGameName());
        dto.setBoardSize(pGame.getBoardSize());
        dto.setNbPlayers(pGame.getNbPlayer());
        dto.setCurrentPlayerId(pGame.getCurrentPlayer());
        dto.setGameStatus(pGame.getGameStatus());
        dto.setPlayersIdList(pGame.getPlayerIdList());
        return dto;
    }
    public String getTokenName() {
        return tokenName;
    }
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }
    public String getTokenIdPlayer() {
        return tokenIdPlayer;
    }
    public void setTokenIdPlayer(String tokenIdPlayer) {
        this.tokenIdPlayer = tokenIdPlayer;
    }
    public int getxOldCor() {
        return xOldCor;
    }
    public void setxOldCor(Integer xOldCor) {
        this.xOldCor = xOldCor;
    }
    public int getyOldCor() {
        return yOldCor;
    }
    public void setyOldCor(Integer yOldCor) {
        this.yOldCor = yOldCor;
    }
    public int getxNewCor() {
        return xNewCor;
    }
    public void setxNewCor(int xNewCor) {
        this.xNewCor = xNewCor;
    }
    public int getyNewCor() {
        return yNewCor;
    }
    public void setyNewCor(int yNewCor) {
        this.yNewCor = yNewCor;
    }
}
