SUMMARY = "2boom plugins for Open Vision"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep gitpkgv ${PYTHONNAMEONLY}native gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/2boom-plugins.git;protocol=http"

S = "${WORKDIR}/git"

PROVIDES = "\
	enigma2-plugin-extensions-arbouquet \
	enigma2-plugin-extensions-epanel \
	enigma2-plugin-extensions-epgdd \
	enigma2-plugin-extensions-ipktools \
	enigma2-plugin-extensions-ltv \
	enigma2-plugin-extensions-m2b \
	enigma2-plugin-extensions-qcifh \
	enigma2-plugin-extensions-qeifh \
	enigma2-plugin-extensions-qerfh \
	enigma2-plugin-extensions-quickecminfo \
	enigma2-plugin-extensions-quickemurestart \
	enigma2-plugin-extensions-reloadsl \
	enigma2-plugin-extensions-remountnetshare \
	enigma2-plugin-extensions-rpulite \
	enigma2-plugin-extensions-tpulite \
	enigma2-plugin-extensions-updatepreview \
	enigma2-plugin-extensions-yweather \
	enigma2-plugin-extensions-ywfh \
	"

DEPENDS = "\
	bitratecalc \
	python-pycurl \
	"

DESCRIPTION_enigma2-plugin-extensions-arbouquet = "Add remove bouquet plugin by 2boom"
DESCRIPTION_enigma2-plugin-extensions-epanel = "epanel plugin by 2boom"
FILES_enigma2-plugin-extensions-epanel_append = " ${prefix}/script/*.sh"
RDEPENDS_enigma2-plugin-extensions-epanel = "ntpdate ${PYTHONNAMEONLY}-requests"
DESCRIPTION_enigma2-plugin-extensions-epgdd = "2boom's Auto EPG Loader"
DESCRIPTION_enigma2-plugin-extensions-ipktools = "2boom's IPK Tools"
DESCRIPTION_enigma2-plugin-extensions-ltv = "2boom's Lanet Loader"
DESCRIPTION_enigma2-plugin-extensions-m2b = "2boom's m3u/bouquet converter"
DESCRIPTION_enigma2-plugin-extensions-qcifh = "QuickChannelInfo for Hotkey plugin by 2boom"
RDEPENDS_enigma2-plugin-extensions-qcifh = "bitratecalc"
DESCRIPTION_enigma2-plugin-extensions-qeifh = "QuickEcmInfo for Hotkey plugin by 2boom"
RDEPENDS_enigma2-plugin-extensions-qeifh = "bitratecalc"
DESCRIPTION_enigma2-plugin-extensions-qerfh = "QuickEmuRestart for Hotkey plugin by 2boom"
DESCRIPTION_enigma2-plugin-extensions-quickecminfo = "Quick Ecm Info plugin by 2boom"
RDEPENDS_enigma2-plugin-extensions-quickecminfo = "bitratecalc"
FILES_enigma2-plugin-extensions-quickecminfo_append = " ${libdir}/enigma2/python/Components/Converter/QuickEcmInfo2.pyo"
FILES_enigma2-plugin-extensions-quickecminfo-src_append = " ${libdir}/enigma2/python/Components/Converter/QuickEcmInfo2.py"
DESCRIPTION_enigma2-plugin-extensions-quickemurestart = "Quick Emu Restart plugin by 2boom"
DESCRIPTION_enigma2-plugin-extensions-reloadsl = "ReloadSL plugin simply re-reads the channels and favorites lists without rebooting the enigma by 2boom"
DESCRIPTION_enigma2-plugin-extensions-remountnetshare = "Remount Net Share plugin by 2boom"
DESCRIPTION_enigma2-plugin-extensions-rpulite = "Rostelecom (Sibtelecom) IPTV-updater plugin by 2boom"
RDEPENDS_enigma2-plugin-extensions-rpulite = "curl python-pycurl"
DESCRIPTION_enigma2-plugin-extensions-tpulite = "Triolan (Ukraine) IPTV-updater pluign by 2boom"
RDEPENDS_enigma2-plugin-extensions-tpulite = "curl"
DESCRIPTION_enigma2-plugin-extensions-updatepreview = "Update preview plugin by 2boom"
FILES_enigma2-plugin-extensions-updatepreview_append = " ${libdir}/enigma2/python/Screens/Console2.pyo"
FILES_enigma2-plugin-extensions-updatepreview-src_append = " ${libdir}/enigma2/python/Screens/Console2.py"
DESCRIPTION_enigma2-plugin-extensions-yweather = "Yahoo weather plugin by 2boom"
DESCRIPTION_enigma2-plugin-extensions-ywfh = "Yahoo weather plugin for Hotkey by 2boom"

ALLOW_EMPTY_${PN} = "1"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINE} \
    --with-boxbrand=${BOX_BRAND} \
    --with-stbplatform=${STB_PLATFORM} \
    --with-arch=${TARGET_ARCH} \
    "

do_package_qa() {
}
