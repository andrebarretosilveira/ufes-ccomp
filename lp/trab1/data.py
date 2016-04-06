#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Data:
    def __init__(self, dia, mes, ano):
        self.dia = dia
        self.mes = mes
        self.ano = ano

    def __eq__(self, dataHoje):
        return self.dia == dataHoje.dia and self.mes == dataHoje.mes

    def dif(self, data):
        return int(data.ano) - int(self.ano)

    def toString(self):
        return str(self.dia) + "/" + str(self.mes) + "/" + str(self.ano)
