DESCRIPTION = "RSi Media Center by OpenRSi"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenE2/rsimediacenter-plugin.git;protocol=git"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}${base_bindir}/dvd_player ${D}${bindir}/

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

do_install_azboxhd() {
	install -d ${D}${bindir}/
	install -m 0755 ${S}${base_bindir}/dvd_player-ForHD ${D}${bindir}/dvd_player

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
