DESCRIPTION = "Azbox IPTV plugin"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/AZIPTV.git;protocol=git"

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
	install -d  ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV
	
	install -m 0644 ${S}/*.pyo \
	${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV

	install -m 0755 ${S}/config \
	${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Picons/
        install -m 0644 ${S}/Picons/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Picons/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Ico/
        install -m 0644 ${S}/Ico/*.png ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Ico/

        install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Lists/
        install -m 0755 ${S}/Lists/* ${D}${libdir}/enigma2/python/Plugins/Extensions/AzIPTV/Lists/
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/AzIPTV"

PACKAGES = "enigma2-plugin-extensions-aziptv"

PROVIDES="${PACKAGES}"
