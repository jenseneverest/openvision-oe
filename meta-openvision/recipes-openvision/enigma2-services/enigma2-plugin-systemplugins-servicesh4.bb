DESCRIPTION = "servicelibeplayer backend for enigma2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/enigma2-mediaservice"
RPROVIDES_${PN} += "virtual/enigma2-mediaservice"

DEPENDS = "\
	enigma2 \
	libeplayer3 \
	${PYTHONNAMEONLY} \
	"

RDEPENDS_${PN} = "\
	enigma2 \
	libeplayer3 \
	"

RRECOMMENDS_${PN} = "\
	glib-networking \
	libeplayer3 \
	"

SRC_URI = "git://github.com/OpenVisionE2/servicemp3epl.git;branch=libeplayer"

S = "${WORKDIR}/git"

inherit autotools gitpkgv ${PYTHONNAMEONLY}native pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	--with-boxtype=${MACHINE} \
	--with-boxbrand=${BOX_BRAND} \
	--with-stbplatform=${STB_PLATFORM} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/*.${PYTHONEXTENSION} \
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/servicelibpl.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/Servicelibpl/servicelibpl.la"
