SUMMARY = "Persian Empire plugins for Open Vision"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep gitpkgv ${PYTHONNAMEONLY}native gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/persianempire-plugins.git;protocol=http"

S = "${WORKDIR}/git"

PROVIDES = "\
	enigma2-plugin-extensions-airplayer \
	enigma2-plugin-extensions-blockcontent \
	enigma2-plugin-extensions-camrestart \
	enigma2-plugin-extensions-deviceinfo \
	enigma2-plugin-extensions-fontmagnifier \
	enigma2-plugin-extensions-localemanager \
	enigma2-plugin-extensions-navibarpe \
	enigma2-plugin-extensions-packagemanager \
	enigma2-plugin-extensions-pecammanager \
	enigma2-plugin-extensions-pefaq \
	enigma2-plugin-extensions-peinfo \
	enigma2-plugin-extensions-peweather \
	enigma2-plugin-extensions-pureprestige \
	enigma2-plugin-extensions-quickweather \
	enigma2-plugin-extensions-softcamupdater \
	enigma2-plugin-extensions-vusolo2cihighbitratefix \
	enigma2-plugin-systemplugins-bouquetprotection \
	enigma2-plugin-systemplugins-networkserver \
	enigma2-plugin-systemplugins-pepanel \
	enigma2-plugin-systemplugins-sambaserver \
	enigma2-plugin-systemplugins-satelliteeditor \
	enigma2-plugin-systemplugins-serviceeditor \
	enigma2-plugin-systemplugins-simplesatscan \
	"

DEPENDS = "\
	${@bb.utils.contains("MACHINE", "dm800", "", "dvb-apps", d)} \
	hairtunes \
	hddtemp \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", "python-subprocess", d)} \
	unrar \
	"

RDEPENDS_enigma2-plugin-extensions-airplayer = "${PYTHONNAMEONLY}-ctypes ${PYTHONNAMEONLY}-misc ${PYTHONNAMEONLY}-shell ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", "python-subprocess", d)} gst-plugins-bad-fragmented hairtunes"
DESCRIPTION_enigma2-plugin-extensions-blockcontent = "Block Content for enigma2"
FILES_enigma2-plugin-extensions-deviceinfo_append = " ${libdir}/enigma2/python/Components/Converter/ProgressDiskSpaceInfo.pyo"
FILES_enigma2-plugin-extensions-deviceinfo-src_append = " ${libdir}/enigma2/python/Components/Converter/ProgressDiskSpaceInfo.py"
RDEPENDS_enigma2-plugin-extensions-deviceinfo = "hddtemp"
DESCRIPTION_enigma2-plugin-extensions-fontmagnifier = "Tool to modify enigma 2 gui font sizes"
RDEPENDS_enigma2-plugin-extensions-packagemanager = "unrar"
RDEPENDS_enigma2-plugin-extensions-peinfo = "unrar"
FILES_enigma2-plugin-extensions-pureprestige += "$(sysconfdir)/PurePrestigefeeds.xml"
FILES_enigma2-plugin-extensions-pureprestige_append = " $(sysconfdir)/cron"
RDEPENDS_enigma2-plugin-extensions-pureprestige = "${@bb.utils.contains_any("IMAGE_FSTYPES", "jffs2nfi ubinfi", "dreambox-buildimage mtd-utils-jffs2" , "", d)}"
DESCRIPTION_enigma2-plugin-extensions-vusolo2cihighbitratefix = "Fixes VU Solo2 CI high bitrate bug"
FILES_enigma2-plugin-systemplugins-pepanel_append = " ${bindir}"
RDEPENDS_enigma2-plugin-systemplugins-pepanel = "${@bb.utils.contains("MACHINE", "dm800", "", "dvbdate", d)}"
DESCRIPTION_enigma2-plugin-systemplugins-satelliteeditor = "Satellites Editor"
DESCRIPTION_enigma2-plugin-systemplugins-serviceeditor = "Services Editor"
RDEPENDS_enigma2-plugin-systemplugins-serviceeditor = "enigma2-plugin-systemplugins-satelliteeditor"

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
