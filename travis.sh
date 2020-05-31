#!/bin/bash
echo ""

set -ex

SRC_DIR=${1-$(pwd)}

mkdir -p $SRC_DIR
cd $SRC_DIR
git clone -b develop --depth 1 https://github.com/persianpros/openpli-oe-core.git
cd openpli-oe-core
make init update
git clone --depth 1 https://github.com/OpenVisionE2/openvision-oe.git
cd openvision-oe
git pull
git submodule sync
git submodule update --init
METAS="$( ls | grep meta- | tr '\n' ' ' | sed 's/ $//g' )"
cd ..
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/DISTRO = "openpli"/DISTRO = "openvision"/g' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/openpli.conf/openvision.conf/g' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/bitbake openpli/bitbake openvision/g' {} \;
rm -f build/conf/bblayers.conf
make init update
sed -i "s# $(pwd)/meta-dream##g" build/conf/bblayers.conf
sed -i "s# $(pwd)/meta-axasuhd##g" build/conf/bblayers.conf
sed -i "s# $(pwd)/meta-edision##g" build/conf/bblayers.conf
for i in ${METAS}
do
    echo "BBLAYERS_append = \" $SRC_DIR/openpli-oe-core/openvision-oe/${i}\"" >> build/conf/bblayers.conf
done
echo "BBLAYERS_append = \" $SRC_DIR/openpli-oe-core/openvision-oe\"" >> build/conf/bblayers.conf
rm -rf meta-openpli/recipes-extended/tzdata
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-dlnabrowser.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-dlnaserver.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-lcd4linux.bb
cd build
source env.source
MACHINE=dm7020hd bitbake image || BITBAKE_RESULT=1
