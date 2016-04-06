#!/usr/bin/env python
# -*- coding: utf-8 -*-

from catalago import *

# Arquivos
catal = "catalago.txt"
saida = "saida.txt"
atual = "atual.txt"

# Criando o catálago vazio
catalago = Catalago()

catalago.lerCatalago(catal)
catalago.atualizarCatalago(atual)
catalago.escreverSaida(saida)
catalago.escreverCatalago(catal)
