package com.javanauta.usuario.business.converter;

import com.javanauta.usuario.business.dto.EnderecoDTO;
import com.javanauta.usuario.business.dto.TelefoneDTO;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Endereco;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioConverter {

    // DTO → Entity
    public Usuario paraUsuario(UsuarioDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .enderecos(paraListaEndereco(dto.getEnderecos()))
                .telefones(paraListaTelefone(dto.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> dtos) {
        return dtos.stream().map(this::paraEndereco).collect(Collectors.toList());
    }

    public Endereco paraEndereco(EnderecoDTO dto) {
        return Endereco.builder()
                .id(dto.getId())
                .rua(dto.getRua())
                .numero(dto.getNumero())
                .cidade(dto.getCidade())
                .complemento(dto.getComplemento())
                .cep(dto.getCep())
                .estado(dto.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> dtos) {
        return dtos.stream().map(this::paraTelefone).collect(Collectors.toList());
    }

    public Telefone paraTelefone(TelefoneDTO dto) {
        return Telefone.builder()
                .id(dto.getId())
                .numero(dto.getNumero())
                .ddd(dto.getDdd())
                .build();
    }



    // Entity → DTO
    public UsuarioDTO paraUsuarioDTO(Usuario entity) {
        return UsuarioDTO.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .senha(entity.getSenha())
                .enderecos(paraListaEnderecoDTO(entity.getEnderecos()))
                .telefones(paraListaTelefoneDTO(entity.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> entities) {
        return entities.stream().map(this::paraEnderecoDTO).collect(Collectors.toList());
    }

    public EnderecoDTO paraEnderecoDTO(Endereco entity) {
        return EnderecoDTO.builder()
                .id(entity.getId())
                .rua(entity.getRua())
                .numero(entity.getNumero())
                .cidade(entity.getCidade())
                .complemento(entity.getComplemento())
                .cep(entity.getCep())
                .estado(entity.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> entities) {
        return entities.stream().map(this::paraTelefoneDTO).collect(Collectors.toList());
    }

    public TelefoneDTO paraTelefoneDTO(Telefone entity) {
        return TelefoneDTO.builder()
                .numero(entity.getNumero())
                .ddd(entity.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity){
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha() )
                .enderecos(entity.getEnderecos())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .telefones(entity.getTelefones())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity){
        return Endereco.builder()
                .id(entity.getId())
                .rua(dto.getRua() != null ? dto.getRua() : entity.getRua())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
                .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
                .complemento(dto.getComplemento() != null ? dto.getComplemento() : entity.getComplemento())
                .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity){
        return Telefone.builder()
                .id(entity.getId())
                .ddd(entity.getDdd() != null ? dto.getDdd() : entity.getDdd())
                .numero(entity.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .build();
    }
}
