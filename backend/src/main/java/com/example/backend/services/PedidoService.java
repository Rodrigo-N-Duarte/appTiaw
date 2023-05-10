package com.example.backend.services;

import com.example.backend.models.Empresa;
import com.example.backend.models.Item;
import com.example.backend.models.Pedido;
import com.example.backend.models.Usuario;
import com.example.backend.models.dto.ItemDTO;
import com.example.backend.models.dto.PedidoDTO;
import com.example.backend.repositories.EmpresaRepository;
import com.example.backend.repositories.ItemRepository;
import com.example.backend.repositories.PedidoRepository;
import com.example.backend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ItemRepository itemRepository;
    public void cadastraPedido(Pedido pedido){
        Pedido novo = new Pedido();
        novo.setPago(false);

        Empresa empresa = empresaRepository.findById(pedido.getEmpresa().getId()).get();
        novo.setEmpresa(empresa);

        Usuario usuario = usuarioRepository.findById(pedido.getUsuario().getId()).get();
        novo.setUsuario(usuario);

        pedidoRepository.save(novo);
    }
    public List<PedidoDTO> buscarPorUsuario(Long id){
        List<PedidoDTO> pedidosUsuario = new ArrayList<>();
        pedidosUsuario.forEach(pedido -> {
            if (pedido.getId_usuario() == id){
                pedidosUsuario.add(pedido);
            }
        });
        return pedidosUsuario;
    }
    public PedidoDTO buscarPorId(Long id){
        Pedido pedido = pedidoRepository.findById(id).get();
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setPago(pedido.getPago());
        dto.setId_usuario(pedido.getUsuario().getId());
        dto.setId_empresa(pedido.getEmpresa().getId());

        List<ItemDTO> listItem = new ArrayList<>();
        pedido.getItens().forEach(item -> {
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setNome(item.getNome());
            itemDTO.setPreco(item.getPreco());
            itemDTO.setId_cardapio(item.getCardapio().getId());

            listItem.add(itemDTO);
        });

        dto.setId_itens(listItem);
        return dto;
    }
    public List<PedidoDTO> buscaTodos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> dtos = new ArrayList<>();

        pedidos.forEach(pedido -> {
            PedidoDTO dto = new PedidoDTO();
            dto.setId(pedido.getId());
            dto.setPago(pedido.getPago());
            dto.setId_usuario(pedido.getUsuario().getId());
            dto.setId_empresa(pedido.getEmpresa().getId());

            List<ItemDTO> listItem = new ArrayList<>();
            pedido.getItens().forEach(item -> {
                ItemDTO itemDTO = new ItemDTO();
                itemDTO.setId(item.getId());
                itemDTO.setNome(item.getNome());
                itemDTO.setPreco(item.getPreco());
                itemDTO.setId_cardapio(item.getCardapio().getId());

                listItem.add(itemDTO);
            });

            dto.setId_itens(listItem);
            dtos.add(dto);
        });

        return dtos;
    }
    public void adicionarItem(Long idPedido, Long idItem){
        Pedido pedido = pedidoRepository.findById(idPedido).get();
        Item item = itemRepository.findById(idItem).get();

        Set<Item> listaItens = pedido.getItens();
        listaItens.add(item);

        pedido.setItens(listaItens);

        pedidoRepository.save(pedido);
    }
}
