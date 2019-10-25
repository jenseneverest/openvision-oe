#!/bin/sh
echo ""
if [ $# -eq 0 ]
then
	BUILDDIR="build"
else
	BUILDDIR="$1"
fi
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
echo "Open Vision by"
echo "https://github.com/orgs/OpenVisionE2/people"
echo ""
echo "Each time you run this script all git repositories will get updated to their latest versions!"
echo ""
echo -e "${BLUE}Is there a merge conflict with PLi's repos?"
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}No ${NC}- ${GREEN}Yes"
echo -e ""
echo -e "${BLUE}Enter conflict mode:${NC}"
echo -e "${GREEN}"
read CONFLICTMODE
echo -e "${NC}"
if [ $CONFLICTMODE != "Yes" -a $CONFLICTMODE != "No" ]
then
	echo -e "${BLUE}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo -e "${BLUE}Updating from git, please wait ...${NC}"
echo ""
SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"
cd "${SCRIPTPATH}"
git pull
git submodule sync
git submodule update --init
echo ""
echo -e "${BLUE}Done!${NC}"
echo ""
METAS="$( ls | grep meta- | tr '\n' ' ' | sed 's/ $//g' )"
cd ..
if [ $CONFLICTMODE = "No" ]
then
	git pull
fi
if [ $CONFLICTMODE = "Yes" ]
then
	# Lets restore everything first.
	git checkout .
	# Clear the modifications we've done to the submodules before updating.
	git submodule foreach git checkout .
	git pull --rebase
fi
sed -i "s#BUILD_DIR = \$(CURDIR)/.*#BUILD_DIR = \$(CURDIR)/${BUILDDIR}#g" Makefile
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/DISTRO = "openpli"/DISTRO = "openvision"/g' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/openpli.conf/openvision.conf/g' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/bitbake openpli/bitbake openvision/g' {} \;
# Remove existing PLi metas from bblayers.conf
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-amiko/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-axasuhd/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-dream/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-edision/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-formuler/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-gfutures/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-gi/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-gigablue/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-local/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-maxytec/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-miraclebox/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-qviart/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-sab/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-spycat/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-vuplus/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-xp/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-xpeedc/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-xsarius.pli5/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-xtrend/d' {} \;
find -maxdepth 1 -name "Makefile" -type f -exec sed -i '/meta-zgemma/d' {} \;
echo ""
echo -e "${BLUE}Check for dm7020hdv2 required changes ...${NC}"
if grep -Fqi "DMTYPE" Makefile
then
    echo ""
    echo -e "${BLUE}No need to modify Makefile."
    echo -e "You can compile dm7020hdv2 image too.${NC}"
    echo ""
else
    echo ""
    echo -e "${BLUE}We need to modify Makefile ...${NC}"
    find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/$(MACHINE)/$(MACHINE)$(DMTYPE)/g' {} \;
    find -maxdepth 1 -name "Makefile" -type f -exec sed -i 's/"MACHINE"/"MACHINE DMTYPE"/g' {} \;
    find -maxdepth 1 -name "Makefile" -type f -exec sed -i "s/.@echo 'export MACHINE' >> $@.*/&\n\t@echo 'export DMTYPE' >> \$\@/" {} \;
    cat openvision-oe/dm7020hdv2-changes >> Makefile
    rm -f ${BUILDDIR}/env.source
    echo -e "${BLUE}Done, now you can compile dm7020hdv2 image too.${NC}"
    echo ""
fi
# Regenerate bblayers.conf so we can add our own
rm -f ${BUILDDIR}/conf/bblayers.conf
make init update
echo ""
for i in ${METAS}
do
    echo "BBLAYERS_append = \" ${SCRIPTPATH}/${i}\"" >> ${BUILDDIR}/conf/bblayers.conf
done
echo "BBLAYERS_append = \" ${SCRIPTPATH}\"" >> ${BUILDDIR}/conf/bblayers.conf
cp -f openvision-oe/conf/license/LICENSE-CLOSE meta-openpli/licenses
rm -rf meta-openpli/recipes-connectivity/mediatek
rm -rf meta-openpli/recipes-connectivity/realtek
rm -rf meta-openpli/recipes-core/base-files
rm -rf meta-openpli/recipes-core/busybox
rm -rf meta-openpli/recipes-extended/tzdata
rm -rf meta-openpli/recipes-multimedia/tuxtxt
rm -rf meta-openpli/recipes-openpli/e2openplugins/enigma2-plugin-extensions-openwebif.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-dlnabrowser.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-dlnaserver.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-epgimport-rytec.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-lcd4linux.bb
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugin-extensions-openwebif.bbappend
rm -rf meta-openpli/recipes-openpli/enigma2-plugins/enigma2-plugins.bb
rm -rf meta-openpli/recipes-openpli/enigma2-softcams
rm -rf meta-openpli/recipes-openpli/images
rm -rf meta-openpli/recipes-openpli/streamproxy
