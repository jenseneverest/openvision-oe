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

python populate_packages_prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/bin/rmfp_player ${D}${bindir}/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/
	install -m 0644 ${S}/plugin/*.pyo ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
	install -m 0644 ${S}/img/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
}

do_install_azboxhd() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/bin/rmfp_player-ForHD ${D}${bindir}/rmfp_player

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/
	install -m 0644 ${S}/plugin/*.pyo ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
	install -m 0644 ${S}/img/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/
}

FILES_${PN} = "${bindir}/"
FILES_${PN} += "${libdir}"
FILES_${PN} += "${sysconfdir}/init.d/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/AZPlay/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/AZPlay/img/"
