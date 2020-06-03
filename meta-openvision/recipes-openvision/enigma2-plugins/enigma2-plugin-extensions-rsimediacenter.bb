DESCRIPTION = "RSi Media Center by OpenRSi"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenE2/rsimediacenter-plugin.git;protocol=git"

S = "${WORKDIR}/git"

python populate_packages_prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

do_install_azboxhd() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/bin/dvd_player-ForHD ${D}${bindir}/dvd_player

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0644 ${S}/plugin/*.pyo ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0644 ${S}/plugin/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0755 ${S}/plugin/*.so ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0755 ${S}/plugin/*.xml ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/fonts/
        install -m 0644 ${S}/plugin/fonts/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/fonts/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/
        install -m 0644 ${S}/plugin/skins/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/
        install -m 0755 ${S}/plugin/skins/default/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/
        install -m 0644 ${S}/plugin/skins/default/images/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/buttons/
        install -m 0644 ${S}/plugin/skins/default/images/buttons/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/buttons/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/icons/
        install -m 0644 ${S}/plugin/skins/default/images/icons/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/icons/
}

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}/bin/dvd_player ${D}${bindir}/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0644 ${S}/plugin/*.pyo ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0644 ${S}/plugin/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0755 ${S}/plugin/*.so ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

	install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/
	install -m 0755 ${S}/plugin/*.xml ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/fonts/
        install -m 0644 ${S}/plugin/fonts/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/fonts/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/
        install -m 0644 ${S}/plugin/skins/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/
        install -m 0755 ${S}/plugin/skins/default/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/
        install -m 0644 ${S}/plugin/skins/default/images/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/buttons/
        install -m 0644 ${S}/plugin/skins/default/images/buttons/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/buttons/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/icons/
        install -m 0644 ${S}/plugin/skins/default/images/icons/*.* ${D}${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/icons/
}

FILES_${PN} = "${bindir}/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/fonts/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/buttons/"
FILES_${PN} += "${libdir}/enigma2/python/Plugins/Extensions/MediaCenter/skins/default/images/icons/"
