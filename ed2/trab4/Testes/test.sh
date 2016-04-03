#!/bin/bash

N=$1
INPUT=$2
TIMEFORMAT="%Us + %Ss"

ALGORITHM=("bubble" "insertion" "selection" "shake"
           "shell" "merge" "heap" "quickprimeiro"
           "quickcentral" "quickmediana3"
           "quickrandom" "rank" "radix" "radixbin")

echo "Testes de tamanho $N" 
echo 

for i in "${ALGORITHM[@]}"
do
    echo "$i" 
    ( time timeout 60s ../trab4 "$i" $N < $INPUT ) 2>&1
    echo 
done

echo "====================" 
echo
