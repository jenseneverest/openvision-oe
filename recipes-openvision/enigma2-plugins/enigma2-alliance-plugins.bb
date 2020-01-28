SUMMARY = "OE-Alliance plugins for Open Vision"
MAINTAINER = "Open Vision Developers"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools-brokensep gitpkgv pythonnative gettext

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/alliance-plugins.git;protocol=http"

S = "${WORKDIR}/git"

PACKAGES += "\
    enigma2-plugin-extensions-lcd4linux \
"

PROVIDES = "\
    enigma2-plugin-extensions-btdevicesmanager \
    enigma2-plugin-extensions-dlnabrowser \
    enigma2-plugin-extensions-dlnaserver \
    enigma2-plugin-extensions-fempa \
    enigma2-plugin-extensions-lcd4linux \
    enigma2-plugin-extensions-ondemand \
    enigma2-plugin-extensions-rcuselect \
    enigma2-plugin-extensions-rezap \
    enigma2-plugin-extensions-streamtv \
    enigma2-plugin-extensions-tunerserver \
    enigma2-plugin-extensions-webbrowser \
    enigma2-plugin-systemplugins-abmcustommiximporter \
    enigma2-plugin-systemplugins-audioeffect \
    enigma2-plugin-systemplugins-blindscan \
    enigma2-plugin-systemplugins-channelsimporter \
    enigma2-plugin-systemplugins-dmblindscan \
    enigma2-plugin-systemplugins-ewvfdcontrol \
    enigma2-plugin-systemplugins-f3ledcontrol \
    enigma2-plugin-systemplugins-firmwareupgrade \
    enigma2-plugin-systemplugins-fpgaupgrade \
    enigma2-plugin-systemplugins-gigablueremote \
    enigma2-plugin-systemplugins-gigabluevfdcontrol \
    enigma2-plugin-systemplugins-inivfdcontrol \
    enigma2-plugin-systemplugins-micomupgrade \
    enigma2-plugin-systemplugins-misplslcnscan \
    enigma2-plugin-systemplugins-multitranscodingsetup \
    enigma2-plugin-systemplugins-odinm7vfdcontrol \
    enigma2-plugin-systemplugins-remotecontrolcode \
    ${@bb.utils.contains("MACHINE", "dm800", "", "enigma2-plugin-systemplugins-satipclient", d)} \
    enigma2-plugin-systemplugins-sf8vfdcontrol \
    enigma2-plugin-systemplugins-simplefancontrol \
    enigma2-plugin-systemplugins-terrestrialscan \
    enigma2-plugin-systemplugins-transcodingsetup \
    enigma2-plugin-systemplugins-ventonfancontrol \
    enigma2-plugin-systemplugins-vpledcontrol \
    enigma2-plugin-systemplugins-vuduofancontrol \
    ${@bb.utils.contains("MACHINE_FEATURES", "legacykernel", "" , "enigma2-plugin-systemplugins-wirelessaccesspoint", d)} \
    enigma2-plugin-systemplugins-xtrendfancontrol \
    enigma2-plugin-systemplugins-xtrendremote \
    "

TRANSCODING_CHECK = "${@bb.utils.contains_any("MACHINE_FEATURES", "vuplus gigablue dags", "transtreamproxy", "streamproxy", d)}"

DEPENDS = "\
    ${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbc", "virtual/blindscan-dvbc" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "virtual/blindscan-dvbs" , "", d)} \
    bluez-alsa \
    bluez-conf \
    bluez-hidd \
    ${@bb.utils.contains("MACHINE_FEATURES", "legacykernel", "" , "bridge-utils hostapd", d)} \
    djmount \
    enigma2-plugin-systemplugins-autobouquetsmaker \
    hddtemp \
    librtmp \
    libupnp \
    minidlna \
    neon \
    python-beautifulsoup python-dnspython python-gdata python-icalendar python-lxml python-pexpect python-pyamf python-pyusb python-simplejson \
    ${@bb.utils.contains("MACHINE", "dm800", "", "satipclient", d)} \
    ${@bb.utils.contains_any("MACHINE_FEATURES", "streamproxy transcoding multitranscoding", "${TRANSCODING_CHECK}", "", d)} \
    "

DESCRIPTION_enigma2-plugin-extensions-btdevicesmanager = "BT devices manger to pair e.x keyboard or mouse"
RDEPENDS_enigma2-plugin-extensions-btdevicesmanager = "bluez5-testtools bluez5 bluez-hcidump bluez-conf bluez-hidd bluez-alsa alsa-utils-aplay python-pexpect"
DESCRIPTION_enigma2-plugin-extensions-dlnabrowser = "this is dlna/upnp browser using djmount"
RDEPENDS_enigma2-plugin-extensions-dlnabrowser = "djmount fuse-utils libfuse2 libupnp libneon27"
DESCRIPTION_enigma2-plugin-extensions-dlnaserver = "this is dlna server using minidlna"
RDEPENDS_enigma2-plugin-extensions-dlnaserver = "minidlna"
DESCRIPTION_enigma2-plugin-extensions-fempa = "Norwegian P4 FEM PAA radio show player."
DESCRIPTION_enigma2-plugin-extensions-lcd4linux = "Web/DPF/Samsung LCD control"
DEPENDS_enigma2-plugin-extensions-lcd4linux = "bitratecalc lcd4linux png-util"
RDEPENDS_enigma2-plugin-extensions-lcd4linux = "bitratecalc lcd4linux python-icalendar python-pyusb python-codecs python-datetime python-imaging python-textutils python-twisted-web python-shell python-ctypes libusb1 python-mutagen python-zlib python-email python-subprocess python-simplejson python-soco"
FILES_enigma2-plugin-extensions-lcd4linux_append = "${libdir}/enigma2/python/Components/Renderer/*.pyo ${libdir}/enigma2/python/Plugins/Extensions/LCD4linux/plugin.py"
FILES_enigma2-plugin-extensions-lcd4linux-src_append = "${libdir}/enigma2/python/Components/Renderer/*.py"
DESCRIPTION_enigma2-plugin-extensions-ondemand = "Watch on demand TV."
RDEPENDS_enigma2-plugin-extensions-ondemand = "python-beautifulsoup python-dnspython python-lxml python-pyamf python-simplejson"
DESCRIPTION_enigma2-plugin-extensions-rcuselect = "Change Remote for Amlogic"
DESCRIPTION_enigma2-plugin-extensions-rezap = "ReZap Sync Tool for Wetek"
DESCRIPTION_enigma2-plugin-extensions-streamtv = "iptv player"
RDEPENDS_enigma2-plugin-extensions-streamtv = "rtmpdump"
DESCRIPTION_enigma2-plugin-extensions-tunerserver = "Builds a virtual channels list"
DESCRIPTION_enigma2-plugin-extensions-webbrowser = "Webbrowser launcher"
FILES_enigma2-plugin-extensions-webbrowser_append = "${datadir}/keymaps"
RDEPENDS_enigma2-plugin-extensions-webbrowser = "python-gdata libqtwebkite4 webbrowser-utils qt4-embedded-fonts qt4-embedded-plugin-imageformat-gif qt4-embedded-plugin-imageformat-ico qt4-embedded-plugin-imageformat-jpeg qt4-embedded-plugin-imageformat-mng qt4-embedded-plugin-imageformat-svg qt4-embedded-plugin-imageformat-tiff qt4-embedded-plugin-iconengine-svgicon"
DESCRIPTION_enigma2-plugin-systemplugins-abmcustommiximporter = "Imports ABM CustomMix files from Github."
DESCRIPTION_enigma2-plugin-systemplugins-audioeffect = "Audio Effect setup"
DESCRIPTION_enigma2-plugin-systemplugins-blindscan = "blindscan"
RDEPENDS_enigma2-plugin-systemplugins-blindscan = "${@bb.utils.contains("MACHINE_FEATURES", "blindscan-tbs", "blindscan-s2" , "", d)}"
RRECOMMENDS_enigma2-plugin-systemplugins-blindscan = "virtual/blindscan-dvbs"
DESCRIPTION_enigma2-plugin-systemplugins-channelsimporter = "Imports a copy of the channel list from a remote receiver and loads it on the local receiver."
DESCRIPTION_enigma2-plugin-systemplugins-dmblindscan = "blindscan"
RRECOMMENDS_enigma2-plugin-systemplugins-dmblindscan = "virtual/blindscan-dvbs"
DESCRIPTION_enigma2-plugin-systemplugins-xtrendfancontrol = "Control your internal system fan."
RDEPENDS_enigma2-plugin-systemplugins-xtrendfancontrol = "hddtemp"
DESCRIPTION_enigma2-plugin-systemplugins-firmwareupgrade = "Upgrade your system Firmware"
DESCRIPTION_enigma2-plugin-systemplugins-fpgaupgrade = "Upgrade your system FPGA"
DESCRIPTION_enigma2-plugin-systemplugins-micomupgrade = "micomupgrade"
DESCRIPTION_enigma2-plugin-systemplugins-multitranscodingsetup = "Setup multitranscoding"
DEPENDS_enigma2-plugin-systemplugins-satipclient = "satipclient"
DESCRIPTION_enigma2-plugin-systemplugins-satipclient = "Satip Client setup"
REPLACES_enigma2-plugin-systemplugins-satipclient = "enigma2-plugin-extensions-satipclient"
RDEPENDS_enigma2-plugin-systemplugins-satipclient = "satipclient"
DESCRIPTION_enigma2-plugin-systemplugins-terrestrialscan = "Selects the strongest transponders where there are duplicates and allows filtering by network id."
DESCRIPTION_enigma2-plugin-systemplugins-transcodingsetup = "Setup transcoding"
DESCRIPTION_enigma2-plugin-systemplugins-wirelessaccesspoint = "Using a Wireless module as AP."
RDEPENDS_enigma2-plugin-systemplugins-wirelessaccesspoint = "bridge-utils hostapd"

do_compile_append() {
    python -O -m compileall ${S}
}

ALLOW_EMPTY_${PN} = "1"
PACKAGES += "${PN}-meta"
FILES_${PN}-meta = "${datadir}/meta"

EXTRA_OECONF = "\
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-boxtype=${MACHINE} \
    --with-boxbrand=${BOX_BRAND} \
    --with-arch=${TARGET_ARCH} \
    "

do_install_append() {
    # remove unused .pyc files
    find ${D}${libdir}/enigma2/python/ -name '*.pyc' -exec rm {} \;
    # make scripts executable
    find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'

    if [ "${MACHINE}" == "dm800" ]
    then
        rm -Rf ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/SatipClient
    fi
}

do_package_qa() {
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}
