SUMMARY = "Plex Client for Enigma2 by Don Davici"
MAINTAINER = "Don Davici"

require conf/license/license-gplv2.inc

inherit autotools-brokensep gitpkgv ${PYTHONNAMEONLY}native gettext rm_python_pyc compile_python_pyo no_python_src

PV = "2.1.3+git${SRCPV}"
PKGV = "2.1.3+git${GITPKGV}"

DEPENDS = "${PYTHONNAMEONLY} virtual/gettext"
RDEPENDS_${PN} += "curl mjpegtools ${PYTHONNAMEONLY}-ctypes libshowiframe0 ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "python3-pillow", "python-imaging", d)}"

SRC_URI = " \
	git://github.com/DonDavici/DreamPlex.git;protocol=git \
	file://skin.zip \
	file://blue.patch;patch=1 \
	"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    "

do_install_append() {
	mkdir -p ${D}${libdir}/enigma2/python/Plugins/Extensions/DreamPlex
	rm -f ${D}${libdir}/enigma2/python/Plugins/Extensions/DreamPlex/skins/default_FHD/skin.xml
	cp -r ${WORKDIR}/DreamPlex/* ${D}${libdir}/enigma2/python/Plugins/Extensions/DreamPlex/
}

PACKAGES += "enigma2-plugin-extensions-dreamplex-meta"
FILES_enigma2-plugin-extensions-dreamplex-meta = "${datadir}/meta"

S = "${WORKDIR}/git"
