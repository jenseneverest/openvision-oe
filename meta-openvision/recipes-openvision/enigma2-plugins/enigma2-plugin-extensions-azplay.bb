DESCRIPTION = "Azbox AZplayer app plugin"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

RDEPENDS_${PN} = "curl fuse libupnp djmount libjpeg-turbo libpng"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/AZPlay.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}${base_bindir}/rmfp_player ${D}${bindir}/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/
	install -m 0644 ${S}/plugin/*.${PYTHONEXTENSION}  ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
	install -m 0644 ${S}/img/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
}

do_install_azboxhd() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}${base_bindir}/rmfp_player-ForHD ${D}${bindir}/rmfp_player

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/
	install -m 0644 ${S}/plugin/*.${PYTHONEXTENSION}  ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
	install -m 0644 ${S}/img/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
}

FILES_${PN} = "${bindir}/"
FILES_${PN} += "${libdir}"
FILES_${PN} += "${sysconfdir}/init.d/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/AZPlay/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/"
