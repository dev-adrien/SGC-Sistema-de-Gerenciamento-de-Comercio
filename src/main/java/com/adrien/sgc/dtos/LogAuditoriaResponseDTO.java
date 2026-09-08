package com.adrien.sgc.dtos;

import java.time.LocalDateTime;
import com.adrien.sgc.entities.LogAuditoria;

public class LogAuditoriaResponseDTO {

    private Long id;
    private Long usuarioId;
    private String usuarioNome;
    private String acao;
    private String tipoEvento;
    private LocalDateTime dataHora;
    private String ip;

    public LogAuditoriaResponseDTO() {
    }

    public LogAuditoriaResponseDTO(LogAuditoria entity) {
        this.id = entity.getId();
        this.usuarioId = entity.getUsuario().getId();
        this.usuarioNome = entity.getUsuario().getNome();
        this.acao = entity.getAcao();
        this.tipoEvento = entity.getTipoEvento();
        this.dataHora = entity.getDataHora();
        this.ip = entity.getIp();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}