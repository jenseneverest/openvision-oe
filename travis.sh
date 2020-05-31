#!/bin/bash
echo ""

set -ex

SRC_DIR=${1-$(pwd)}

mkdir -p $SRC_DIR
cd $SRC_DIR
git clone --depth 1 https://github.com/persianpros/openpli-oe-core.git
cd openpli-oe-core
make init update
git clone --depth 1 https://github.com/OpenVisionE2/openvision-oe.git
cd openvision-oe
git pull
git submodule sync
git submodule update --init
METAS="$( ls | grep meta- | tr '\n' ' ' | sed 's/ $//g' )"
cd ..
cat openvision-oe/Makefile-Vision > Makefile
rm -f build/conf/bblayers.conf
make init update
for i in ${METAS}
do
    echo "BBLAYERS_append = \" $SRC_DIR/openpli-oe-core/openvision-oe/${i}\"" >> build/conf/bblayers.conf
done
echo "BBLAYERS_append = \" $SRC_DIR/openpli-oe-core/openvision-oe\"" >> build/conf/bblayers.conf
cd build
source env.source
MACHINE=dm7020hd bitbake image || BITBAKE_RESULT=1
