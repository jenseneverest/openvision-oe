SUMMARY = "Open Vision core plugin"
MAINTAINER = "Open Vision Developers"

require conf/license/license-gplv2.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2 python-process libcrypto-compat gettext-native"
RDEPENDS_enigma2-plugin-systemplugins-visioncore = "python-process libcrypto-compat python-compression zip procps python-beautifulsoup4 bzip2"

RCONFLICTS_enigma2-plugin-systemplugins-visioncore = "settings-autorestore"
RREPLACES_enigma2-plugin-systemplugins-visioncore = "settings-autorestore"

PROVIDES += "openvision-core-plugin"
RPROVIDES_enigma2-plugin-systemplugins-visioncore += "openvision-core-plugin"

inherit autotools-brokensep gitpkgv pythonnative rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI="git://github.com/OpenVisionE2/openvision-core-plugin.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    "

PACKAGES =+ "enigma2-plugin-systemplugins-visioncore"
PACKAGES =+ "enigma2-plugin-systemplugins-visioncore-src"
PACKAGES =+ "enigma2-plugin-systemplugins-visioncore-po"
CONFFILES_enigma2-plugin-systemplugins-visioncore += "${sysconfdir}/exports"
FILES_enigma2-plugin-systemplugins-visioncore = "${sysconfdir} ${libdir}"

FILES_enigma2-plugin-systemplugins-visioncore-po = "${libdir}/enigma2/python/Plugins/SystemPlugins/Vision/locale/*.po"

do_install_append() {
    if [ -f ${DEPLOY_DIR_IMAGE}/burn.bat ]; then
        install -m 755 ${DEPLOY_DIR_IMAGE}/burn.bat ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/Vision/burn.bat
    fi
}
