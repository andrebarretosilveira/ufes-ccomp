#!/usr/bin/env python
# -*- coding: utf-8 -*-

###
#   Trabalho 1 de LP - Python
#   André Barreto Silveira
###

from catalago import *

# Criando o catálago vazio
catalago = Catalago()

catalago.lerCatalago("catalago.txt")
catalago.atualiza("atual.txt")
catalago.ordena(Livro.comparaCodigo)
catalago.escreveSaida("saida.txt")
#catalago.escreverCatalago("catalago2.txt")
