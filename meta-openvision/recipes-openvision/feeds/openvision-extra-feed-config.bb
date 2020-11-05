DESCRIPTION = "Configuration file for Open Vision extra feeds"

require conf/license/openvision-gplv2.inc

FEEDS = "picons 3rdparty"

DISTRO_EXTRA_FEED_URI = "https://raw.githubusercontent.com/OpenVisionE2"

do_compile() {
    [ ! -d ${S}${sysconfdir}/opkg ] && mkdir -p ${S}${sysconfdir}/opkg
    for feed in ${FEEDS}; do
        echo "src/gz openvision-${feed}-feed ${DISTRO_EXTRA_FEED_URI}/${feed}-feed/master/feed/" > ${S}${sysconfdir}/opkg/openvision-${feed}-feed.conf
    done
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644 ${S}${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

CONFFILES_${PN} += '${@ " ".join( [ ( "${sysconfdir}/opkg/openvision-%s-feed.conf" % feed ) for feed in "${FEEDS}".split() ] ) }'
