DESCRIPTION = "Handle your EPG on enigma2 from various sources (opentv, xmltv, custom sources)"
HOMEPAGE = "https://github.com/OpenVisionE2/CrossEPG"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "libxml2 zlib swig-native curl python"
RDEPENDS_${PN} += "libcurl enigma2 python-compression python-lzma xz python-core"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv python-dir gettext rm_python_pyc compile_python_pyo no_python_src

PV = "0.8.7+gitr${SRCPV}"
PKGV = "0.8.7+gitr${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/CrossEPG.git;protocol=git"

S = "${WORKDIR}/git"

CFLAGS_append = " -I${STAGING_INCDIR}/libxml2/ -I${STAGING_INCDIR}/${PYTHON_DIR}/"
CFLAGS_append = " ${@bb.utils.contains_any('BOX_BRAND', 'xtrend xp gfutures formuler airdigital', ' -DNO_DVB_POLL' , '', d)}"

do_compile() {
    echo ${PV} > ${S}/VERSION
    oe_runmake SWIG="swig"
}

do_install() {
    oe_runmake 'D=${D}' install
    mv ${D}/usr/crossepg/libcrossepg.so ${D}${libdir}/

    find ${S}/po -name \*.po -execdir sh -c 'msgfmt "$0" -o `basename $0 .po`.mo' '{}' \;

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/ar/LC_MESSAGES
    install -m 644 ${S}/po/ar.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/ar/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/cs/LC_MESSAGES
    install -m 644 ${S}/po/cs.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/cs/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/de/LC_MESSAGES
    install -m 644 ${S}/po/de.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/de/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/es/LC_MESSAGES
    install -m 644 ${S}/po/es.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/es/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fa/LC_MESSAGES
    install -m 644 ${S}/po/fa.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fa/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fi/LC_MESSAGES
    install -m 644 ${S}/po/fi.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fi/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fr/LC_MESSAGES
    install -m 644 ${S}/po/fr.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/fr/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/it/LC_MESSAGES
    install -m 644 ${S}/po/it.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/it/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/lt/LC_MESSAGES
    install -m 644 ${S}/po/lt.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/lt/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/nl/LC_MESSAGES
    install -m 644 ${S}/po/nl.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/nl/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/pl/LC_MESSAGES
    install -m 644 ${S}/po/pl.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/pl/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/pt/LC_MESSAGES
    install -m 644 ${S}/po/pt.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/pt/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/ru/LC_MESSAGES
    install -m 644 ${S}/po/ru.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/ru/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/sv/LC_MESSAGES
    install -m 644 ${S}/po/sv.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/sv/LC_MESSAGES/CrossEPG.mo

    install -d ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/uk/LC_MESSAGES
    install -m 644 ${S}/po/uk.mo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG/po/uk/LC_MESSAGES/CrossEPG.mo
}

pkg_postrm_${PN}() {
    rm -fr ${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG > /dev/null 2>&1
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends="enigma2")
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}_append = " /usr/crossepg ${libdir}/libcrossepg.so ${libdir}/${PYTHONPATHVERSION}"
FILES_${PN}-src_append = " ${libdir}/${PYTHONPATHVERSION}/crossepg.py"
FILES_${PN}-dbg_append = " /usr/crossepg/scripts/mhw2epgdownloader/.debug /usr/crossepg/scripts/mhw2epgdownloader/.debug"
FILES_SOLIBSDEV = ""
