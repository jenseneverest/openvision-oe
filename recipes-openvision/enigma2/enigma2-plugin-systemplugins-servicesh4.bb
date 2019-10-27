DESCRIPTION = "servicelibeplayer backend for enigma2"
AUTHOR = "OpenVision"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/enigma2-mediaservice"
RPROVIDES_${PN} += "virtual/enigma2-mediaservice"

CXXFLAGS_append_sh4 += " -std=c++11 -fPIC -fno-strict-aliasing "

DEPENDS = "\
	enigma2 \
	libeplayer3 \
	"

RDEPENDS_${PN} = "\
	enigma2 \
	libeplayer3 \
	"

RRECOMMENDS_${PN} = "\
	glib-networking \
	virtual/gstreamer${GST_VERSION}-dvbmediasink \
	libeplayer3 \
	"

SRC_URI = "git://github.com/OpenVisionE2/servicemp3epl.git;branch=libeplayer"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pythonnative pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

do_install_append() {
	rm ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/*.pyc
}

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/*.pyo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/servicelibpl.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/*.py \
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/servicelibpl.la"
