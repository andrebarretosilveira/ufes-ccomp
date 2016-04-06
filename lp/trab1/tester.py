#!/usr/bin/env python
# -*- coding: utf-8 -*-

from catalago import *

# Criando o catálago vazio
catalago = Catalago()

catalago.lerCatalago("catalago.txt")
catalago.atualizaCatalago("atual.txt")
catalago.escreverCatalago("saida.txt")
