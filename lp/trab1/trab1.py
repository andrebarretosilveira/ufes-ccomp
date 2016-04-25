#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   trab1.py
#
#   Trabalho 1 de LP - Python
#   André Barreto Silveira
###

from catalogo import *

# Criando o catálogo vazio
catalogo = Catalogo()

catalogo.lerCatalogo("catalogo.txt")
catalogo.atualiza("atual.txt")
catalogo.escreveSaida("saida.txt")
catalogo.ordena(Livro.comparaCodigo)
catalogo.escreveCatalogo("catalogo.txt")
