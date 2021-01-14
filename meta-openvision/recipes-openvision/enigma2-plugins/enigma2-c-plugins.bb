SUMMARY = "C plugins for Open Vision"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep gitpkgv ${PYTHONNAMEONLY}native gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/c-plugins.git;protocol=http"

S = "${WORKDIR}/git"

PROVIDES = "\
	enigma2-plugin-extensions-airplayer \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-permanenttimeshift \
	enigma2-plugin-systemplugins-misplslcnscan \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-terrestrialscan \
	enigma2-plugin-systemplugins-vps \
	"

DEPENDS = "\
	enigma2 \
	hairtunes \
	libtirpc \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-six", "python-six-native", d)} \
	"

CFLAGS += "-I${STAGING_INCDIR}/tirpc"
LDFLAGS += "-ltirpc"

RDEPENDS_enigma2-plugin-extensions-airplayer = "${PYTHONNAMEONLY}-ctypes ${PYTHONNAMEONLY}-misc ${PYTHONNAMEONLY}-shell ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", "python-subprocess32", d)} ${GSTVNAME}-plugins-bad-fragmented hairtunes"
DESCRIPTION_enigma2-plugin-systemplugins-terrestrialscan = "Selects the strongest transponders where there are duplicates and allows filtering by network id."
#RDEPENDS_enigma2-plugin-systemplugins-networkbrowser = "autofs smbclient"

ALLOW_EMPTY_${PN} = "1"
PACKAGES += "${PN}-meta"
FILES_${PN}-meta = "${datadir}/meta"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --without-debug \
    --with-boxtype=${MACHINE} \
    --with-boxbrand=${BOX_BRAND} \
    --with-stbplatform=${STB_PLATFORM} \
    --with-arch=${TARGET_ARCH} \
    "

do_package_qa() {
}
