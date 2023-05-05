package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Pedido;
import com.example.backend.models.Usuario;
import com.example.backend.repositories.EmpresaRepository;
import com.example.backend.repositories.PedidoRepository;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;
    public void cadastraPedido(Pedido pedido){
        Pedido novo = new Pedido();
        novo.setPago(false);

        Empresa empresa = empresaRepository.findById(pedido.getEmpresa().getId()).get();
        novo.setEmpresa(empresa);

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId()).get();
        novo.setUsuario(usuario);

        pedidoRepository.save(novo);
    }
}
