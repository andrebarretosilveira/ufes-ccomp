#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   Trabalho 1 de LP - Python
#   André Barreto Silveira
###

from catalogo import *

# Criando o catálago vazio
catalogo = Catalogo()

catalogo.lerCatalogo("catalogo.txt")
catalogo.atualiza("atual.txt")
catalogo.ordena(Livro.comparaCodigo)
catalogo.escreveSaida("saida.txt")
catalogo.escreveCatalogo("catalogo.txt")
